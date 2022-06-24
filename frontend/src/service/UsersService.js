import axios from "axios";
import authHeader from "./authHeader";
import { BASE_URL } from "./config";

const UsersService = (function () {
	const _getAll = async () => {
		try {
			const response = await axios.get(BASE_URL + "/api/users/get-all" , { headers : authHeader()});

			return response;
		} catch (error) {
			console.log(error);
		}
	};
	const _removeUser = async (id) => {
		try {
			const response = await axios.get(BASE_URL + "/api/users/remove", { headers : authHeader(), params : {"user-id" : id}});

			return response;
		} catch (error) {
			return error;
		}
	};

	const _saveUser = async (credentials) => {
		try {
			const response = await axios.post(BASE_URL + "/api/users/add", { headers : authHeader(), body : {"credentials" : credentials}});

			return response;
		} catch (error) {
			console.log("err : " + error);

			return error;
		}
	};

	return {
		getAll : _getAll,
		removeUser : _removeUser,
		saveUser : _saveUser
	};
})();

export default UsersService;