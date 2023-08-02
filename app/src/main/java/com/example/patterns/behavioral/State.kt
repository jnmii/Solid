package com.example.patterns.behavioral

class State {
    class MySpecificEvent { /* Additional fields if needed */ }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: MySpecificEvent?) {
        /* Do something */
    }

    EventBus.getDefault().post(MySpecificEvent())
    val printing = Printer()
    printing.startPrinting() // Printed Successfully.
    printing.startPrinting() // Printed Successfully.
    printing.startPrinting() // Printer doesn't have ink.
    printing.installInk() // Ink installed.
    printing.startPrinting() // Printed Successfully.

}