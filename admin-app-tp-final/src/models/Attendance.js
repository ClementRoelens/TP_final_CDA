class Attendance {
    constructor(id,start,end,employeeId) {
        this.id = id
        this.start = start
        this.end = end
        this.employeeId = employeeId
    }


    get id() {
        return this.id
    }
    get start() {
        return this.start
    }
    get end() {
        return this.end
    }
    get employeeId() {
        return this.employeeId
    }

}

export default Attendance