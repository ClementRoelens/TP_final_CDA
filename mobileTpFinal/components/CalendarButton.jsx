import React, {useState} from 'react';
import { TouchableOpacity } from 'react-native';
import {Calendar, LocaleConfig} from 'react-native-calendars';

const CalendarButton = () => {
  const [selected, setSelected] = useState('');
  const [isDatePickerVisible, setDatePickerVisibility] = useState(false);

  return (
    // <TouchableOpacity>

    // </TouchableOpacity>
    <Calendar
      onDayPress={day => {
        setSelected(day.dateString);
      }}
      markedDates={{
        [selected]: {selected: true, disableTouchEvent: true, selectedDotColor: 'orange'}
      }}
    />
  );
};

export default CalendarButton;