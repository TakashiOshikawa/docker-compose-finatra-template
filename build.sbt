lazy val root = (project in file(".")).
  settings(
    name := "finatra-server",
    version := "1.0",
    scalaVersion := "2.11.7",
    libraryDependencies ++= dervy,
    resolvers ++= resolve
  )

lazy val dervy = {
  Seq(
    "com.twitter" % "finatra-http_2.11" % "2.6.0"
  )
}

lazy val resolve = {
  Seq(
    Resolver.sonatypeRepo("releases"),
    "Twitter Maven" at "https://maven.twttr.com"
  )
}
