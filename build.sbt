organization := "net.koofr"

name := "java-koofr"

version := "1.2.7"

resolvers += "restlet" at "http://maven.restlet.org"

autoScalaLibrary := false

crossPaths := false

lazy val sdk = project in file(".")

javacOptions ++= Seq("-source", "1.6")

javacOptions in compile ++= Seq("-target", "1.6")

seq(bintraySettings:_*)

licenses ++= Seq("MIT" -> url("http://opensource.org/licenses/MIT"))

publishArtifact in Test := false

pomExtra :=
  <url>https://github.com/koofr/java-koofr</url>
    <licenses>
      <license>
        <name>MIT</name>
        <url>http://opensource.org/licenses/MIT</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>https://github.com/koofr/java-koofr.git</url>
    </scm>
    <developers>
      <developer>
        <id>jkmcnk</id>
        <name>Jaka Mocnik</name>
      </developer>
      <developer>
        <id>edofic</id>
        <name>Andraz Bajt</name>
      </developer>
    </developers>


libraryDependencies ++= Seq(
  "org.apache.httpcomponents" % "httpclient" % "4.2.1",
  "org.restlet.jse" % "org.restlet.ext.jackson" % "2.1.2",
  "org.restlet.jse" % "org.restlet.ext.httpclient" % "2.1.2" exclude("org.restlet.jse", "org.restlet.ext.ssl")
)

lazy val exampleCmdline = Project(
  id = "cmdline",
  base = file("examples/cmdline"),
  settings = Project.defaultSettings ++ Seq(mainClass in (Compile,run) := Some("cmdline.Main"))
) dependsOn sdk

lazy val exampleInfo = Project(
  id = "info",
  base = file("examples/info"),
  settings = Project.defaultSettings ++ Seq(mainClass in (Compile,run) := Some("info.Main"))
) dependsOn sdk
