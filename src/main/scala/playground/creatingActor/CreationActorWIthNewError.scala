package playground.creatingActor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object CreationActorWIthNewError extends App {

  val actorSystem = ActorSystem("TestSystem")

  println(actorSystem.name)

  class FirstActor extends Actor {

    // internal data
    var count = 0

    // behavior
    def receive: PartialFunction[Any, Unit] = {
      case message: String =>
        count += message.length
        println(message)
        println(count)
    }
  }

  // will throw an error
  // create actor can only with system.actorOf
  new FirstActor()
}
