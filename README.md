# BlogBackPro
## Build and run the project
### My enviroment  
MacOS 13.3, Java19, IntelliJ IDEA 2022.3.3, SpringBoot Freamwork
### Pull the code
You already done that!
### install the DB
1, install MySql follow the tutorial (https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/).  
2, I recommend you to use some GUI DB tool like Navicat.  
3, excute the blogend.sql file by any DB management tool you like, I use Navicat.  
4, after that, my database shoule been copied on your local computer.  
5, my DB account name is root, my password is 12345678. You could set the same account and password like mine so you don't need to modify anything of the application.yml file.  
6, run your DB.
### Open and run with IDE, take IDEA as an example (I highly recommend you to use IntelliJ IDEA!!!)
1, open IDEA, click the Open button.  
2, select the pom.xml file in the project folder, and click the Open as Project button.  
3, my database port is 3306, and my database name is test, if you set these the same with mine, you don't need to modify anything of the project files.  
4, otherwise, please modify these parameters in the application.yml file in the resources folder.  
5, IDEA has already integrated maven, so you don't need any configuration, just wait for maven automatically grab every library this project need.  
6, when maven finish its job, just click the Run button of green color on the top bar of the window and it will run the Run.  
<img width="303" alt="image" src="https://user-images.githubusercontent.com/117051280/229684191-7a46ef3d-22d5-4287-a96d-687975fbd749.png">  
6, when maven finish its job, just click the Run button of green color on the top bar of the window and it will run the DemoApplication.    
7, now I beileve the backend service is running on 8080 port.  
## Backend Service  
plase open the files in src/main/java/com/BlogBackPro/controller  
there are 3 different controllers, follow the "@PostMapping" is the request URL, you can input them into postman like this(follow "localhost:8080"):  
<img width="572" alt="image" src="https://user-images.githubusercontent.com/117051280/229683663-c6696cb8-a9bf-4ef9-867d-7eeff18fc40f.png">
don't forget login first (localhost:8080/user/login) and get the token (pic below), and evert time you send any request, don't forget the token:  
<img width="319" alt="image" src="https://user-images.githubusercontent.com/117051280/229683829-24565d3c-a9ed-4e3c-9f5a-b77e7c77a8c2.png">  
you can construct the bean follow the different beans in "src/main/java/com/BlogBackPro/model".

