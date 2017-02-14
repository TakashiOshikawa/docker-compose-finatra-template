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

assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs @ _*)         => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
