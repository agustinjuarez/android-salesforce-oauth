android-salesforce-oauth
=========================

Simple oAuth2 login for Salesforce without using the Mobile SDK from SFDC.

Credits go to: https://github.com/tomgersic for the original app I stripped down to the core oauth2 login contents.

This app is a simple login function without the need of the Salesforce Mobile SDK for Android (which  is horribly bugged).

In order to use, just fill in the appropriate data in strings.xml (in the 'values' folder). 

These values are: 

    <string name="consumer_key"></string>
    <string name="consumer_secret"></string>
    <string name="oAuthUrl">https://na15.salesforce.com/services/oauth2/authorize?response_type=token&amp;display=touch&amp;client_id=</string>
    <string name="callbackUrl">https://na15.salesforce.com/services/oauth2/success</string>
    <string name="API_Version">v22.0</string>
    <string name="oAuthRefreshUrl">https://na15.salesforce.com/services/oauth2/token</string>
    
**remember to check SFDC instance (ie.: na15)

Enjoy!
