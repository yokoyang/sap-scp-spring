# sap-scp-spring deploy
in cmd terminal (I suggest use Cmder)

cf login

API 端點: https://api.cf.eu10.hana.ondemand.com

Email>

Password>

Space>

IdeaProjects\demo>mvn package to build the Project


cf push demo-java

If you want to see all your Apps, type:

cf apps

demo-java        started           1/1         256M     1G     demo-java.cfapps.eu10.hana.ondemand.com

# Important thing

the config file is the manifest.yml, you should read it before start.
