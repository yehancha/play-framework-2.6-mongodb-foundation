name := """mashtapp-api"""
organization := "com.mashtapp"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  guice,
  "uk.co.panaxiom" %% "play-jongo" % "2.1.0-jongo1.3"
)