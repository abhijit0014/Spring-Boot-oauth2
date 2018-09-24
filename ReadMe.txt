Access Token Request		localhost:8080/oauth/token 
-------------------------------------------------------
	
	$.ajax({
	    xhrFields: {
	        withCredentials: true
	    },
	    headers: {
	        'Authorization': 'Basic ' + btoa(trusted-app:secret)
	    },
	    data: { grant_type: "password", username: "user", password="password"},
	    url: "http://localhost:8080/oauth/token"
	});

	response
	--------
		{
		    "access_token": "eyJhbGciOiJIUzI1NiIs....",
		    "token_type": "bearer",
		    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR...",
		    "expires_in": 43199,
		    "scope": "read write",
		    "jti": "32a91263-a772-4af6-8c80-f02e016e0334"
		}


Resource Access				localhost:8080/api/hello
-------------------------------------------------------
	$.ajax({
	  url: "http://localhost:8080/resource",
	  type: 'GET',
	  // Fetch the stored token from localStorage and set in the header
	  headers: { "Authorization": 'Bearer ' + localStorage.getAccessToken('token')}
	});
	
	