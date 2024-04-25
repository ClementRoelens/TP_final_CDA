package org.example.backtpfinal;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeCalculation {
        private static final int HOURS_PER_DAY = 7;

        private static final int HOURS_PER_WEEK = 35;

        public static void main(String[] args) {
            // List des périodes entrée sorties d'un salarié en semaine
            LocalDateTime[] checkInTimes = {LocalDateTime.of(2024, 4, 22, 8, 0),
                    LocalDateTime.of(2024, 4, 23, 8, 0),
                    LocalDateTime.of(2024, 4, 24, 8, 0),
                    LocalDateTime.of(2024, 4, 25, 8, 0),
                    LocalDateTime.of(2024, 4, 26, 8, 0)};
            LocalDateTime[] checkOutTimes = {LocalDateTime.of(2024, 4, 22, 16, 0),
                    LocalDateTime.of(2024, 4, 23, 15, 30),
                    LocalDateTime.of(2024, 4, 24, 17, 0),
                    LocalDateTime.of(2024, 4, 25, 16, 0),
                    LocalDateTime.of(2024, 4, 26, 16, 30)};

            //Heures total en semaine
            int totalHours = 0;
            for (int i = 0; i < checkInTimes.length; i++) {
                int hoursWorked = calculateHoursWorked(checkInTimes[i], checkOutTimes[i]);
                totalHours += hoursWorked;
                System.out.println("Le " + checkInTimes[i].toLocalDate() + ": " + hoursWorked + " heure(s)");
            }

            // calcule heures supp
            int overtimeHours = Math.max(totalHours - HOURS_PER_WEEK, 0);

            // total heures de travails par semaine
            int regularHours = Math.min(totalHours, HOURS_PER_WEEK);

            // Hiển thị kết quả
            System.out.println("total heures de travails par semaine: " + totalHours + " heures");
            System.out.println("Include:");
            System.out.println("- heures standard: " + regularHours + " heures");
            System.out.println("- heure(s) supp: " + overtimeHours + " heure(s)");
        }

        // calcule heures de travail entre entrée et sortie (en heure)
        private static int calculateHoursWorked(LocalDateTime checkIn, LocalDateTime checkOut) {
            return (int) Duration.between(checkIn, checkOut).toHours();
        }


}
