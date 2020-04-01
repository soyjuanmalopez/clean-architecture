Clean Architecture example

Multiporject maven.

Se realizaron los siguientes pasos para ejecutar el maven con jib para conteinizar apicaciones

El jib directamente compila y pushea nuestra aplicacion en el registry al momento de hacer el install, para esto tenemos que tener instaladas las credenciales de docker por que podria no realizar el build

  51 gcloud aouth login
  52 gcloud auth login
  53 gcloud components update
  54 docker login
  55 gcloud docker login
  56 gcloud auth configure-docker


  # execute the whole build lifecycle and push the image to the registry
mvn package

# only create and push the image.
mvn jib:build
# Note that `jib:build` is daemonless and won't create the image on your machine.
# It talks directly to the registry. Use `docker pull` to fetch the created image.

# only create and push the image via the Docker daemon.
mvn jib:dockerBuild
