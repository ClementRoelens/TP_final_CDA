import React from 'react';
import { fireEvent, render, screen } from '@testing-library/react-native';
import { test, describe, expect, jest } from '@jest/globals';
import HomeScreen from '../screens/HomeScreen';

jest.mock("../components/employeeSlice.js", () => ({
    signin: jest.fn(),
  }));
  
describe("Test du component InputAndLabel", () => {
    test("Le state est mis à jour", () => {
        const store = mockStore({});

        render(
        <Provider store={store}>
            <HomeScreen />
        </Provider>
        );

        const mailInput = screen.getByPlaceholderText("abd@example.com");
        const passwordInput = screen.getByPlaceholderText("*****");
        const signinButton = screen.getByText("Se connecter")

        fireEvent.changeText(mailInput, "user@gmail.com");
        fireEvent.changeText(passwordInput, "1234");
        fireEvent.press(signinButton);

        expect(signin).toHaveBeenCalledWith({
            email: "user@gmail.com",
            password: "1234",
        });
    });
});