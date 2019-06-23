package akka

import akka.actor.Actor

import scala.util.Random

class TeacherActor extends Actor with App {

  val quotes = List(
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try")

  override def receive: Receive = {
    case QuoteRequest => {
      val quoteResponse = QuoteResponse(quotes(Random.nextInt(quotes.size)))
      println(quoteResponse)
    }
  }
}
