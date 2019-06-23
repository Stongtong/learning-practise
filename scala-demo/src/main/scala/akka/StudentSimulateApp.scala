package akka

import akka.actor.{ActorSystem, Props}

object StudentSimulateApp extends App {
  println("student app started !")
  val actorSystem = ActorSystem("UniversityMessageSystem")
  val teacherActorRef = actorSystem.actorOf(Props[TeacherActor])
  teacherActorRef ! QuoteRequest
  Thread.sleep(2000)
//  actorSystem.shutdown()
}
