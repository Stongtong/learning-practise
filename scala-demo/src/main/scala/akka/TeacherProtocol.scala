package akka

object TeacherProtocol {
  case class QuoteRequest()
  case class QuoteResponse(quoteString:String)

}
