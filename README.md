###to run local registry:
```docker run -d -p 5000:5000 --restart=always --name registry registry:2```

###to build and update an image:
```mvn jib:build```

###to push to local rgistry:
```docker push localhost:5000/statdevice:latest``` 

###to run image:
```docker run -t -i -p 8080:8080 localhost:5000/statdevice:latest```
 
 * -t -i  - makes it possible to use Ctrl-C to send stop command to container
 * remember to use -p (port forwarding) BEFORE image name, not after

###contact container:
``` curl localhost:8080/hello?name=asdasdas```

###to run cluster with mongo:
```docker-compose up```

###Jib
*add latest version of jib plugin not to have problems with java version at runtime (source image does not matter) ie.:*

			<plugin>
				<groupId>com.google.cloud.tools</groupId>
				<artifactId>jib-maven-plugin</artifactId>
				<version>2.0.0</version>
				<configuration>
					<allowInsecureRegistries>true</allowInsecureRegistries>
					<container>
						<ports>
							<port>8080</port>
						</ports>
					</container>
					<from>
						<image>openjdk:11</image>
					</from>
					<to>
						<image>localhost:5000/statdevice:latest</image>
					</to>
				</configuration>
			</plugin>