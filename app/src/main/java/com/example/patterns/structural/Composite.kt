package com.example.patterns.structural

class Composite {
    //1
    interface Entity {
        fun getEntityName(): String
    }

    //2
    class Team(private val name: String) : Entity {
        override fun getEntityName(): String {
            return name
        }
    }

    //3
    class Raywenderlich(private val name: String) : Entity {
        private val teamList = arrayListOf<Entity>()

        override fun getEntityName(): String {
            return name + ", " + teamList.map { it.getEntityName() }.joinToString(", ")
        }

        fun addTeamMember(member: Entity) {
            teamList.add(member)
        }
    }
}