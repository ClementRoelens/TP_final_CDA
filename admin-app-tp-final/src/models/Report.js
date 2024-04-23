class Report {
    constructor(id,workedHours,startDate,endDate,employeeId) {
        this.id = id
        this.workedHours = workedHours
        this.startDate = startDate
        this.endDate = endDate
        this.employeeId = employeeId
    }


    get id() {
        return this.id
    }
    get workedHours() {
        return this.workedHours
    }
    get startDate() {
        return this.startDate
    }
    get endDate() {
        return this.endDate
    }
    get employeeId() {
        return this.employeeId
    }

}
export default Report