import React from 'react';
import { fireEvent, render, screen } from '@testing-library/react-native';
import Button from './Button';

describe("Test du component Button", () => {

  it("Est rendu", () => {
    render(<Button text="Confirmer"/>);
    const button = screen.getByText("Confirmer");
    expect(button).toBeDefined();
  });

  it("Action bien exécutée", () => {
    const action = jest.fn();

    render(<Button onPressAction={action} text="Bouton" />);
    const button = screen.getByText
    fireEvent.press(button)

    expect(action).toHaveBeenCalled();
  })

  it("Style heightStyle par défaut", () => {
    render(<Button text="Confirmer"/>);
    const button = screen.getByText("Confirmer");

    const styles = button.parent.props.style;
    const heightStyle = buttonStyles.find(style => style.height === 72);

    expect(heightStyle).toBeDefined();
  })

});
