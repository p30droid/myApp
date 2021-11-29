package com.androidlearn.digiandroid.di;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {


    @Singleton
    @Provides
    Contact provideContact() {
        return new Contact();
    }

    @Singleton
    @Provides
    User provideUser() {
        return new User(new Contact());
    }


}
