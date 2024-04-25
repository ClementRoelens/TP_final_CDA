import React, { useState } from 'react';
import { View, Text, StyleSheet, ScrollView, Button, Modal } from 'react-native';
import CalendarButton from '../components/CalendarButton';
import HeaderInformationComponent from '../components/HeaderInformationComponent';

const WeeklyInformationScreen = ({navigation}) => {
    const [isModalVisible, setModalVisible] = useState(false);

    const toggleModal = () => {
        setModalVisible(!isModalVisible);
    };

    return (
<View  style={styles.mainContainer}>
      <HeaderInformationComponent/>
        <View >
            <ScrollView horizontal={true} >
                <View style={styles.card}>
                    <Text style={styles.cardText}>Card 1</Text>
                </View>
                <View style={styles.card}>
                    <Text style={styles.cardText}>Card 2</Text>
                </View>
                <View style={styles.card}>
                    <Text style={styles.cardText}>Card 3</Text>
                </View>
            </ScrollView >
            <Text style={styles.overtimeText}>
                Exédent : {/* Ajoutez la logique pour afficher l'excédent ici */}
            </Text>
            <View style={styles.date}>
                <Button title={"Ouvrir le calendrier"} onPress={toggleModal} style={styles.calendarButton} />
            </View>
            <Modal
                animationType="slide"
                transparent={true}
                visible={isModalVisible}
                onRequestClose={toggleModal}
            >
                <View style={styles.modalContainer}>
                    <View style={styles.modalContent}>
                        <CalendarButton />
                        <Button title="Fermer" onPress={toggleModal} />
                    </View>
                </View>
            </Modal>
        </View>
</View>
        
    );
}

const styles = StyleSheet.create({
    mainContainer :{
        flex:1
   },

    container: {

        alignItems: 'center',
        justifyContent: 'center',
    },
    card: {
        top: 36,
        width: 287,
        height: 358,
        backgroundColor: 'blue',
        marginHorizontal: 10,
        alignItems: 'center',
        justifyContent: 'center',
        borderRadius: 11,
    },
    cardText: {
        fontSize: 20,
        fontWeight: 'bold',
        color: 'white',
    },
    overtimeText: {
        top: 0,
        textAlign: 'center',
        fontSize: 23,
        fontWeight: 'regular',
        color: '#000000',
    },
    date: {
        alignItems: 'center',
        justifyContent: 'center',
        top: 40,
        textAlign: 'center',
        fontSize: 20,
        fontWeight: 'bold',
        
    },
    dateButton: {
      backgroundColor: '#4C63CA',

    },
    modalContainer: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#4C63CA',
    },
    modalContent: {
        backgroundColor: 'white',
        padding: 20,
        borderRadius: 10,
        elevation: 5,
    },
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

export default WeeklyInformationScreen;
