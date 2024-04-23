Create an http server in springboot.

Enable this scenario

1. User hits POST/api/createNewPost with the json body ("post name": "<some-unique-name>", "post_contents"."<some random string>")
22. App controller should try to insert this post. Something like this Insert into posts ('name', 'contents) values (<some-unique-name>', <some-random-string>")

3. App controller should return the post id if its created successfully. Return the exception if there's an exception in executing query

4. App controller would hit an outbound HTTP call as well. You can take this for example GET http://worldtimeapi.org/api/timezone/Asia/Kolkata

5. This is what should be returned as response of the API/api/createNewPost ("db_post":"<db row with id>", "http_outbound": "<response body received in step 4>" }

 Postgres/Mysql as the database to be used here

 Bytebuddy used for manipulation of library functions
