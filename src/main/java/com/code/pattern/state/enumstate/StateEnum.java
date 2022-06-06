package com.code.pattern.state.enumstate;

/**
 * Created by hejiaxu on 2021/4/29
 */
public enum  StateEnum implements EState {

    New(0) {
        @Override
        public void cancel() {

        }

        @Override
        public void done() {

        }
    },
    CLOSED(13) {
        @Override
        public void cancel() {

        }

        @Override
        public void done() {

        }
    };

    StateEnum(int status) {
        this.status = status;
    }

    int status;

}
