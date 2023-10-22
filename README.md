# ArunCBATestRepo

Description
------------
Created a feature branch named as "feature/ArunSood-CBATest" from main trunk
and initially merged some code in main branch to test the develop and code on CI server.

This is a sample regression suite which i have created as a part of test.
If asked for then i can automate each and every API for each and every business logic test, status code, etc in the PET, STORE and USER API.

---------------------
HOW TO RUN THE CODE
-------------------
I have setup a Continues Integration Server named Teamcity on cloud which and have set up a BuildCIPipeline, which runs this code everytime any automation developer checks in the code in the GIT repository.

URL for Teamcity cloud is - https://arunsood.teamcity.com/
---------------------------------------------------------
Step 1: Open URL - https://arunsood.teamcity.com/

Step 2: Click on link "continue with username/password"

Step 3: Enter Username
TestManager
and
password
Ruhhi

Step 4: Click on "ArunCBATestRepo" under Projects Menu on the left hand side

Step 5: Click on "BuildCIPipeline" and all the last build run for this project will be visible on screen.

Step 6: On the Top right hand side (under the main Teamcity Cloud header), click on "Run" button.

Step 7: This will trigger the build plan on CI Server, get code from Git Hub, compile and run test cases using maven and finally you will see the code running. Happy Testing :-)




Few improvements which comes TOP of my head, which can be done later are as below:
-----------------------------------------------------------------

0: A lot of Test methods can be added for all the validations which are needed as per business logic testing or requirement of the end user.
This all assertions can be done on the values returned in response body.

1: Read all the hardcoded values from a properties or config file instead of hardcoding the same. 
For ex: Refer line# 21 to set "RestAssured.baseURI" in PetStoreAPITest.java class

2: This is a regression suite only hence have not automated many more scenarios which can actually be automated having many more HTTP Status codes to be tested, for ex:

-----------------------------------------------------------------------------------------
2xx Status Codes [Success]
---------------------------
Status Code
Description
200 OK
Indicates that the request has succeeded.
201 Created
Indicates that the request has succeeded and a new resource has been created as a result.
202 Accepted
Indicates that the request has been received but not completed yet. It is typically used in log running requests and batch processing.
203 Non-Authoritative Information
Indicates that the returned metainformation in the entity-header is not the definitive set as available from the origin server, but is gathered from a local or a third-party copy. The set presented MAY be a subset or superset of the original version.
204 No Content
The server has fulfilled the request but does not need to return a response body. The server may return the updated meta information.
205 Reset Content
Indicates the client to reset the document which sent this request.
206 Partial Content
It is used when the Range header is sent from the client to request only part of a resource.
207 Multi-Status (WebDAV)
An indicator to a client that multiple operations happened, and that the status for each operation can be found in the body of the response.
208 Already Reported (WebDAV)
Allows a client to tell the server that the same resource (with the same binding) was mentioned earlier. It never appears as a true HTTP response code in the status line, and only appears in bodies.
226 IM Used
The server has fulfilled a GET request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.

-----------------------------------------------------------------------------------------
3xx Status Codes (Redirection)
--------------------------------
Status Code
Description
300 Multiple Choices
The request has more than one possible response. The user-agent or user should choose one of them.
301 Moved Permanently
The URL of the requested resource has been changed permanently. The new URL is given by the Location header field in the response. This response is cacheable unless indicated otherwise.
302 Found
The URL of the requested resource has been changed temporarily. The new URL is given by the Location field in the response. This response is only cacheable if indicated by a Cache-Control or Expires header field.
303 See Other
The response can be found under a different URI and SHOULD be retrieved using a GET method on that resource.
304 Not Modified
Indicates the client that the response has not been modified, so the client can continue to use the same cached version of the response.
305 Use Proxy (Deprecated)
Indicates that a requested response must be accessed by a proxy.
306 (Unused)
It is a reserved status code and is not used anymore.
307 Temporary Redirect
Indicates the client to get the requested resource at another URI with same method that was used in the prior request. It is similar to 302 Found with one exception that the same HTTP method will be used that was used in the prior request.
308 Permanent Redirect (experimental)
Indicates that the resource is now permanently located at another URI, specified by the Location header. It is similar to 301 Moved Permanently with one exception that the same HTTP method will be used that was used in the prior request.

-----------------------------------------------------------------------------------------
4xx Status Codes (Client Error)
--------------------------------
Status Code
Description
400 Bad Request
The request could not be understood by the server due to incorrect syntax. The client SHOULD NOT repeat the request without modifications.
401 Unauthorized
Indicates that the request requires user authentication information. The client MAY repeat the request with a suitable Authorization header field
402 Payment Required (Experimental)
Reserved for future use. It is aimed for using in the digital payment systems.
403 Forbidden
Unauthorized request. The client does not have access rights to the content. Unlike 401, the client’s identity is known to the server.
404 Not Found
The server can not find the requested resource.
405 Method Not Allowed
The request HTTP method is known by the server but has been disabled and cannot be used for that resource.
406 Not Acceptable
The server doesn’t find any content that conforms to the criteria given by the user agent in the Accept header sent in the request.
407 Proxy Authentication Required
Indicates that the client must first authenticate itself with the proxy.
408 Request Timeout
Indicates that the server did not receive a complete request from the client within the server’s allotted timeout period.
409 Conflict
The request could not be completed due to a conflict with the current state of the resource.
410 Gone
The requested resource is no longer available at the server.
411 Length Required
The server refuses to accept the request without a defined Content- Length. The client MAY repeat the request if it adds a valid Content-Length header field.
412 Precondition Failed
The client has indicated preconditions in its headers which the server does not meet.
413 Request Entity Too Large
Request entity is larger than limits defined by server.
414 Request-URI Too Long
The URI requested by the client is longer than the server can interpret.
415 Unsupported Media Type
The media-type in Content-type of the request is not supported by the server.
416 Requested Range Not Satisfiable
The range specified by the Range header field in the request can’t be fulfilled.
417 Expectation Failed
The expectation indicated by the Expect request header field can’t be met by the server.
418 I’m a teapot (RFC 2324)
It was defined as April’s lool joke and is not expected to be implemented by actual HTTP servers. (RFC 2324)
420 Enhance Your Calm (Twitter)
Returned by the Twitter Search and Trends API when the client is being rate limited.
422 Unprocessable Entity (WebDAV)
The server understands the content type and syntax of the request entity, but still server is unable to process the request for some reason.
423 Locked (WebDAV)
The resource that is being accessed is locked.
424 Failed Dependency (WebDAV)
The request failed due to failure of a previous request.
425 Too Early (WebDAV)
Indicates that the server is unwilling to risk processing a request that might be replayed.
426 Upgrade Required
The server refuses to perform the request. The server will process the request after the client upgrades to a different protocol.
428 Precondition Required
The origin server requires the request to be conditional.
429 Too Many Requests
The user has sent too many requests in a given amount of time (“rate limiting”).
431 Request Header Fields Too Large
The server is unwilling to process the request because its header fields are too large.
444 No Response (Nginx)
The Nginx server returns no information to the client and closes the connection.
449 Retry With (Microsoft)
The request should be retried after performing the appropriate action.
450 Blocked by Windows Parental Controls (Microsoft)
Windows Parental Controls are turned on and are blocking access to the given webpage.
451 Unavailable For Legal Reasons
The user-agent requested a resource that cannot legally be provided.
499 Client Closed Request (Nginx)
The connection is closed by the client while HTTP server is processing its request, making the server unable to send the HTTP header back.

-----------------------------------------------------------------------------------------
5xx Status Codes (Server Error)
--------------------------------
Status Code
Description
500 Internal Server Error
The server encountered an unexpected condition that prevented it from fulfilling the request.
501 Not Implemented
The HTTP method is not supported by the server and cannot be handled.
502 Bad Gateway
The server got an invalid response while working as a gateway to get the response needed to handle the request.
503 Service Unavailable
The server is not ready to handle the request.
504 Gateway Timeout
The server is acting as a gateway and cannot get a response in time for a request.
505 HTTP Version Not Supported (Experimental)
The HTTP version used in the request is not supported by the server.
506 Variant Also Negotiates (Experimental)
Indicates that the server has an internal configuration error: the chosen variant resource is configured to engage in transparent content negotiation itself, and is therefore not a proper endpoint in the negotiation process.
507 Insufficient Storage (WebDAV)
The method could not be performed on the resource because the server is unable to store the representation needed to successfully complete the request.
508 Loop Detected (WebDAV)
The server detected an infinite loop while processing the request.
510 Not Extended
Further extensions to the request are required for the server to fulfill it.
511 Network Authentication Required
Indicates that the client needs to authenticate to gain network access.

------------------------------------------------------------------------------------------
3: Read absolute file path from a properties file instead of hardcoding the same. 
For ex: Refer line# 42 in PetStoreAPITest.java class
  
 4: Many many more improvements can be done, which can be discussed in the interview if given a chance. :-) Thanks.
