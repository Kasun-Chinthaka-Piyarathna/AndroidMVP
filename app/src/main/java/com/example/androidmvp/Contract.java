package com.example.androidmvp;

public interface Contract {
    interface View {
        void showProgress();

        void hideProgress();

        void setString(String string);
    }

    interface Model {
        interface OnFinishedListener {
            void onFinished(String string);
        }

        void getNextCourse(Contract.Model.OnFinishedListener onFinishedListener);
    }

    interface Presenter {
        void onButtonClick();

        void onDestroy();
    }
}
