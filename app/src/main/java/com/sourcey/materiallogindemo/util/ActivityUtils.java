package com.sourcey.materiallogindemo.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Provides methods to help activity with their UI.
 */
public class ActivityUtils {

    /**
     * Add a fragment {@code fragment} to a container view with id {@code frameId}.
     * FragmentManger {@code fragmentManger} preforms this operations.
     * */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId,fragment);
        transaction.commit();
    }
}
