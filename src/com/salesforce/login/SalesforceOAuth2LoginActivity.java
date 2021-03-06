//Credit to: https://github.com/tomgersic for the original app I stripped down to the core oauth login contents

/*
Copyright (c) 2011, Model Metrics 
All rights reserved. 
Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met: 
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer. 
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution. 
 * Neither the name of Model Metrics nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission. 
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */

package com.salesforce.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.salesforce.login.controller.LoginController;
import com.salesforce.login.rest.OAuthTokens;
import com.salesforce.login.rest.OAuthUtil;

public class SalesforceOAuth2LoginActivity extends Activity {
	//NOT FOR PRODUCTION USE - only use if you want to force login rather than refresh flow, for testing purposes.
	private final Boolean FORCE_LOG_IN = false;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Handle instance where we already have a refresh token and don't need to present the login dialog again
		//save the access tokens to disk for next time
		OAuthTokens tokens = OAuthUtil.Load(getApplicationContext());
		//if we have access tokens saved, use those. Otherwise, log in.
		if(tokens != null && !FORCE_LOG_IN)
		{
    		GlobalState globalState = (GlobalState) getApplication();
			globalState.setAccessTokens(tokens);
			Log.d("TG", "Launching Main View");
			launchMainView();
		}
		else
		{
			Log.d("TG","Launching Login View");
			launchLoginView();
		}        
        
    }
    
	protected void launchLoginView() {
		Intent i = new Intent(this, LoginController.class);
		startActivity(i);
	}
	
	protected void launchMainView(){
		Log.d("TG", "Launched Main View");
	}
    
}