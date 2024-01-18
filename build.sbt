ThisBuild / tlBaseVersion := "0.0"

ThisBuild / organization := "com.cyz1901"
ThisBuild / organizationName := "cyz1901"
ThisBuild / startYear := Some(2024)
ThisBuild / developers := List(
  tlGitHubDev("cyz1901", "cyz1901"),
)

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
  .settings(
    name := "calico-ionic",
    libraryDependencies ++= Seq(
      "com.armanbilge" %%% "calico" % CalicoVersion,
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
