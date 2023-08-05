package app.junsu.appjam23.util

import app.junsu.appjam23.ui.HumanInformation

val dummyMissingPeople = listOf<Pair<HumanInformation,List< String>>>(
    Pair(
        HumanInformation(
            name = "강인혜",
            gender = HumanInformation.Gender.FEMALE,
            age = 18,
        ),
        listOf(
            "안경 착용",
        )
    ),
    // HumanInformation()
)
