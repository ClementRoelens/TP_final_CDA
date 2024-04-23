class Employee {
    constructor(id,firstName,lastName,birthDate,gender,email,password,pay,role,photoPath) {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.birthDate = birthDate
        this.gender = gender
        this.email = email
        this.password = password
        this.pay = pay
        this.role = role
        this.photoPath = photoPath
    }

    get id() {
        return this.id
    }
    
    get firstName() {
        return this.firstName
    }

    get lastName() {
        return this.lastName
    }

    get birthDate() {
        return this.birthDate
    }

    get gender() {
        return this.gender
    }

    get email() {
        return this.email
    }

    get password() {
        return this.password
    }

    
    get pay() {
        return this.pay
    }

    
    get role() {
        return this.role
    }

    
    get photoPath() {
        return this.photoPath
    }
}
export default Employee