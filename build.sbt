scalacOptions ++= Seq("-Ywarn-unused:imports")
scalacOptions ++= Seq("-Xmx4G")

ThisBuild / tlBaseVersion := "0.2"
ThisBuild / tlUntaggedAreSnapshots := true

ThisBuild / organization := "io.github.cyz1901"
ThisBuild / organizationName := "cyz1901"
ThisBuild / startYear := Some(2024)
ThisBuild / developers := List(
  tlGitHubDev("cyz1901", "cyz1901"),
)
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"

ThisBuild / tlSonatypeUseLegacyHost := false

ThisBuild / crossScalaVersions := Seq("3.3.1")
ThisBuild / scalacOptions ++= Seq("-new-syntax", "-indent", "-source:future")

ThisBuild / githubWorkflowJavaVersions := Seq(JavaSpec.temurin("21"))
ThisBuild / tlJdkRelease := Some(8)

val CalicoVersion = "0.2.2"

lazy val root = tlCrossRootProject.aggregate(ionic, sandbox)

lazy val ionic = project
  .in(file("ionic"))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalablyTypedConverterGenSourcePlugin)
  .settings(
    name := "calico-ionic",
    scalaJSLinkerConfig ~= (_.withSourceMap(false)),
    libraryDependencies ++= Seq(
      "com.armanbilge" %%% "calico" % CalicoVersion,
    ),
    Compile / npmDependencies ++= Seq(
      "@ionic/core" -> "7.6.4",
    ),
    Compile / stMinimize := Selection.AllExcept("@ionic/core"),
    stOutputPackage := "calico.ionic.scalablyTyped",
    Compile / unmanagedSourceDirectories ++= Seq(
      file(
        baseDirectory.value + "/ionic/target/scala-3.3.1/src_managed/main/scalablytyped",
      ),
    ),
  )

lazy val sandbox = project
  .in(file("sandbox"))
  .enablePlugins(ScalaJSPlugin, NoPublishPlugin)
  .dependsOn(ionic)
  .settings(
    tlFatalWarnings := false,
    scalaJSUseMainModuleInitializer := true,
    Compile / fastLinkJS / scalaJSLinkerConfig ~= {
      import org.scalajs.linker.interface.ModuleSplitStyle
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("calico.ionic")))
    },
  )
