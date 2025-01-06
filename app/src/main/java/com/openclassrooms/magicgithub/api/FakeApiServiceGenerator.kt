package com.openclassrooms.magicgithub.api

import com.openclassrooms.magicgithub.model.User
import java.util.*

object FakeApiServiceGenerator {

    @JvmField
    var FAKE_USERS = mutableListOf(
        User("001", "Jake", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("002", "Paul", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("003", "Phil", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("004", "Guillaume", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("005", "Francis", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("006", "George", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("007", "Louis", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("008", "Mateo", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("009", "April", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("010", "Louise", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("011", "Elodie", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("012", "Helene", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("013", "Fanny", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("014", "Laura", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("015", "Gertrude", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("016", "Chloé", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("017", "April", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("018", "Marie", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("019", "Henri", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("020", "Rémi", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x")
    )

    @JvmField
    var FAKE_USERS_RANDOM = Arrays.asList(
        User("021", "Lea", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("022", "Geoffrey", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("023", "Simon", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("024", "André", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x"),
        User("025", "Leopold", "https://gravatar.com/avatar/9756e8925968082ee6813ee7d5d6c80f?s=200&d=robohash&r=x")
    )
}