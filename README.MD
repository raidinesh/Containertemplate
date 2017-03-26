TEMPLATE/CONTAINER
==================

This project exists to help bootstrap projects which build containers. The idea is to clone this project to get a skeleton. However, unlike a skeleton, the project has enough content to demonstrate the moving parts of the application.

Steps for cloning a project:
1. Go to <xyz>
2. Use the link above to create the project in gitlab. This will also setup the Gitlab->Jenkins CI/CD linkages.
3. Clone this project.
4. Remove the old source code & tests
5. Start adding new code
6. Grep for 'TODO' in the settings.gradle and build.gradle files. Make the changes as described.
7. Edit the Jenkinsfile to match your desired CI-CD chain. Most of the Jenkinsfile is static, the customizable part starts with "// Most people should only edit things below"
8. Login to gitlab and go to the gitlab project that you created in #2 will have instructions for importing an existing project. Follow those instructions.

Enhanced HealthCheck
=====================
This project now uses a custom health check.
Inside the code there is a TODO which indicates the place that you should replace the health check code with your own.
When in doubt, simply have the health check return UP all the time.  If you do have sophisticated health checks, then you should implement them in the healthEngine package.

Using rebuildproj
=================
There is a helper script in the distribution called rebuildproj.  Invoke the command like so within your Vagrant box:

    cd /vagrant
    ./rebuildproj
    ...

When the script is done, it will have stopped all containers, rebuilt your code and launched the newly rebuilt containers.
The command takes one optional argument, -c.
If -c is present, the script will not run the 'cleanDockerImages' gradle task.
Only use -c if you get an error when cleaning the docker image about a missing ocpm-* layer.

