// Only admin can see
import React, {useEffect, useState} from 'react';
import {Button, Container, Divider, List, Transition} from "semantic-ui-react";
import {useHistory} from "react-router-dom";
import UsersService from "../service/UsersService";
import toastify from "../util/ToastifyUtil";
import {useFormik} from "formik";
import * as Yup from "yup";
import AuthService from "../service/AuthService";
import {StatusCodes} from "http-status-codes";

const SignUpPage = () => {
	const [users, setUsers] = useState([]);
	const [showForm, setShowForm] = useState(false);
	const [flag, setFlag] = useState(false);
	const history = useHistory();
	const initialValues = {username : "", password : "", repassword : "", roles : ""}

	const getUsers = () => {
		UsersService.getAll()
			.then((response) => {
				if (response && response.status === StatusCodes.OK) {
					setUsers(response.data);
				}
				else if (response && response.status === StatusCodes.UNAUTHORIZED) {
					history.push("/signup", {authError : false});
				}
			})
			.catch(reason => {
				console.log(reason);
			});
	}

	useEffect(() => {
		getUsers();
		window.scrollTo(0, 0);
	},[showForm,flag]);

	const schema = Yup.object({
		username : Yup.string().required("No username provided."),
		password : Yup.string().required("No password provided."),
		repassword : Yup.string().oneOf([Yup.ref("password"), null], "Passwords must match"),
	});

	const formik = useFormik(
		{initialValues : initialValues,
			validationSchema : schema,
			onSubmit : (async (values, actions) => handleSubmit(values, actions))},
	);

	const handleSubmit = async (values, actions) => {
		actions.resetForm();

		const credentials = {"username" : values.username,
							 "password" : values.password,
							 }

		const response = await AuthService.signup(credentials);
		if((response && response.status === StatusCodes.OK)) {
			toastify("success", "Registration Sucesfull");
			setFlag(prevState => (!prevState));
		} else if (response && response.status === StatusCodes.UNAUTHORIZED) {
			history.push("/signup", {authError : true});
		} else {
			toastify("error", "User already exist in the database");
		}
	}

	const toggleVisibility = () => {
		setShowForm((prevState) => (!prevState));
	}

	return (
		<div>
			<h1>Sign Up</h1>
			<Divider/>
			<List divided verticalAlign="middle">
				{!! users && users.map((user) =>(
					<List.Item key={user.id}>
						<List.Content><h3>{user.username}</h3></List.Content>

					</List.Item>
				))}
			</List>
			<Divider hidden />
			<Button basic primary
				content={showForm ? "Hide" : "Please Press Button to Sign Up"}
				onClick={() => toggleVisibility()}
			/>
			<Divider hidden />
			<Transition.Group animation="fly down" duration={500}>
				{showForm && (
					<form className="ui form" onSubmit={formik.handleSubmit}>
						<div className="field">
							<label>Username</label>
							<input
								type="text"
								name="username"
								placeholder="Username"
								onChange={formik.handleChange}
								value={formik.values.username}/>

							{formik.errors.username &&
							<div className="ui pointing red basic label">
								{formik.errors.username}</div>
							}
						</div>
						<div className="field">
							<label>Password</label>
							<input
								type="password"
								name="password"
								placeholder="Password"
								onChange={formik.handleChange}
								value={formik.values.password}/>
							{formik.errors.password &&
							<div className="ui pointing red basic label">
								{formik.errors.password}</div>
							}
						</div>
						<div className="field">
							<label>Confirm Password</label>
							<input
								type="password"
								name="repassword"
								placeholder="Confirm Password"
								onChange={formik.handleChange}
								value={formik.values.repassword}/>
							{formik.errors.repassword &&
							<div className="ui pointing red basic label">
								{formik.errors.repassword}</div>
							}
						</div>
						
						<Container textAlign="right">
							<button className="ui positive basic button" type="submit">Please Press Button to Sign Up</button>
						</Container>
					</form>
					)}
			</Transition.Group>
		</div>
	);
};

export default SignUpPage;