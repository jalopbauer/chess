ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := """3.2.0"""

lazy val root = (project in file("."))
  .settings(
    name := "chess_code"
  )
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % Test
