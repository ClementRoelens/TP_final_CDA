import React from 'react';
import { fireEvent, render, screen } from '@testing-library/react-native';
import { test, describe } from '@jest/globals';
import Button from '../components/Button';

describe("Test du component Button", () => {

  test("Est rendu", () => {
    render(<Button text="Confirmer" />);
    const button = screen.getByText("Confirmer");
    expect(button).toBeDefined();
  });

  test("Action bien exécutée", () => {
    const action = jest.fn();

    render(<Button onPressAction={action} text="Bouton" />);
    const button = screen.getByText
    fireEvent.press(button)

    expect(action).toHaveBeenCalled();
  })

  test("Style heightStyle par défaut", () => {
    render(<Button text="Confirmer" />);
    const button = screen.getByText("Confirmer");

    const styles = button.parent.props.style;
    const heightStyle = buttonStyles.find(style => style.height === 72);

    expect(heightStyle).toBeDefined();
  })

});