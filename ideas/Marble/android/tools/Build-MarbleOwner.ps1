# Build an owner-signed APK on the owner's Windows computer.
# Does not generate, copy, upload or print the private signing key or passwords.
param(
    [ValidateSet('Preview', 'Release')]
    [string]$Channel = 'Preview',
    [Parameter(Mandatory = $true)]
    [string]$KeyStore,
    [string]$Alias = 'marble-family'
)

$ErrorActionPreference = 'Stop'
$keyPath = [System.IO.Path]::GetFullPath($KeyStore)
if (-not (Test-Path -LiteralPath $keyPath -PathType Leaf)) {
    throw "Keystore not found: $keyPath"
}

function Read-TemporaryPassword([string]$Prompt) {
    $secure = Read-Host $Prompt -AsSecureString
    $ptr = [Runtime.InteropServices.Marshal]::SecureStringToBSTR($secure)
    try {
        return [Runtime.InteropServices.Marshal]::PtrToStringBSTR($ptr)
    } finally {
        [Runtime.InteropServices.Marshal]::ZeroFreeBSTR($ptr)
        $secure.Dispose()
    }
}

$workingDirectoryChanged = $false
try {
    $env:MARBLE_RELEASE_KEYSTORE = $keyPath
    $env:MARBLE_RELEASE_KEY_ALIAS = $Alias
    $env:MARBLE_RELEASE_STORE_PASSWORD = Read-TemporaryPassword 'Keystore password'
    $env:MARBLE_RELEASE_KEY_PASSWORD = Read-TemporaryPassword 'Key password'

    Push-Location (Join-Path $PSScriptRoot '..')
    $workingDirectoryChanged = $true
    $task = if ($Channel -eq 'Preview') { ':app:assembleFamilyPreview' } else { ':app:assembleRelease' }
    & .\gradlew.bat $task '--no-daemon'
    if ($LASTEXITCODE -ne 0) { throw "Gradle build failed with exit code $LASTEXITCODE" }
} finally {
    if ($workingDirectoryChanged) { Pop-Location }
    Remove-Item Env:MARBLE_RELEASE_KEYSTORE -ErrorAction SilentlyContinue
    Remove-Item Env:MARBLE_RELEASE_KEY_ALIAS -ErrorAction SilentlyContinue
    Remove-Item Env:MARBLE_RELEASE_STORE_PASSWORD -ErrorAction SilentlyContinue
    Remove-Item Env:MARBLE_RELEASE_KEY_PASSWORD -ErrorAction SilentlyContinue
}
