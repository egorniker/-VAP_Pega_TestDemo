PilotRunCukesTest
   ↓
open_pilot_application.feature
   ↓
@pilot tag
   ↓
PilotHooks.loginToPegaViaSSO()
   ↓
CRMBrowser.open()
   ↓
CRMBrowser.user_logs_in_to_pega_platform_via_sso()
   ↓
Selenium / Pega Driver
   ↓
PilotSteps.theUserShouldBeLoggedInToPegaSuccessfully()