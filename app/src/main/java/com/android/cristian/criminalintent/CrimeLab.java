package com.android.cristian.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab crimeLab;
    private List<Crime> crimes;

    public static CrimeLab get(Context context) {
        if (crimeLab == null) {
            crimeLab = new CrimeLab(context);
        }

        return crimeLab;
    }

    private CrimeLab(Context context) {
        crimes = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Crime crime = new Crime();
            crime.setTitle(String.format("Crime #%d", i));
            crime.setSolved(i % 2 == 0);
            crimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public Crime getCrime(UUID uuid) {
        for (Crime crime : crimes) {
            if (crime.getId().equals(uuid)) {
                return crime;
            }
        }

        return null;
    }
}
