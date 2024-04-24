import AsyncStorage from '@react-native-async-storage/async-storage';

export const getHeaders = async () => {
    return { "Authorization": "Bearer " + await AsyncStorage.getItem("token") };
};