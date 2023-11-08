package com.sisco.coachmark

interface SequenceListener{
    fun onNextItem(coachMark : CoachMarkOverlay, coachMarkSequence : CoachMarkSequence){
        coachMarkSequence.setNextView()
    }
}