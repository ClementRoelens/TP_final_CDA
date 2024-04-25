export const getAuthorizationHeadersValue = () => {
    return "Bearer " + localStorage.getItem("token");
};