import React, {useState} from 'react';
import { TouchableOpacity,StyleSheet } from 'react-native';
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


const styles = StyleSheet.create({
  calendarButton: {
    height: 72,
    width: 287,
    backgroundColor : "#4C63CA",
    display:"flex",
    justifyContent:"center",
    alignContent:"center",
    borderRadius:8,
    // Drop shadows à factoriser
    shadowColor: '#000',
    shadowOffset: {
      width: 4, 
      height: 2,
    }}

});