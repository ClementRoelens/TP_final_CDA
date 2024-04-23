class Adress {
    constructor(id,number,street,complement,zipCode,town,country) {
        this.id = id
        this.number = number
        this.street = street
        this.complement = complement
        this.zipCode = zipCode
        this.town = town
        this.country = country
    }

    get id() {
        return this.id
    }
    get number() {
        return this.number
    }
    get street() {
        return this.street
    }
    get complement() {
        return this.complement
    }
    get zipCode() {
        return this.zipCode
    }
    get town() {
        return this.town
    }
    get country() {
        return this.country
    }
}
export default Adress