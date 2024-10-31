import React, { useState } from 'react';
import './Login.css';

const Login = () => {
    const [user, setUser] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(null);
    const [successMessage, setSuccessMessage] = useState(''); // Nuevo estado para el mensaje de éxito

    const handleSubmit = async (e) => {
        e.preventDefault();

        const loginData = {
            user: user,
            password: password
        };

        try {
            const response = await fetch('http://localhost:8080/Api/Login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(loginData),
            });

            if (response.ok) {
                const data = await response.json();
                console.log('Login exitoso:', data);
                setSuccessMessage('¡Inicio de sesión exitoso!'); // Mensaje de éxito
                setError(null); // Limpiar el mensaje de error
            } else {
                setError('Error en el login, verifica tus credenciales');
                setSuccessMessage(''); // Limpiar el mensaje de éxito
            }
        } catch (error) {
            setError('Error al conectar con el servidor');
            setSuccessMessage(''); // Limpiar el mensaje de éxito
            console.error('Error:', error);
        }
    };

    return (
        <div className="login-container">
            <div className="background-bubbles">
                <div className="bubble"></div>
                <div className="bubble"></div>
                <div className="bubble"></div>
                <div className="bubble"></div>
                <div className="bubble"></div>
            </div>

            <form className="login-form" onSubmit={handleSubmit}>
                <h2>Iniciar sesión</h2>

                <div className="input-group">
                    <label htmlFor="user">Usuario:</label>
                    <input
                        type="text"
                        id="user"
                        value={user}
                        onChange={(e) => setUser(e.target.value)}
                        required
                    />
                </div>

                <div className="input-group">
                    <label htmlFor="password">Contraseña:</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>

                {error && <p className="error-message">{error}</p>}
                {successMessage && <p className="success-message">{successMessage}</p>} {/* Mensaje de éxito */}

                <button type="submit" className="login-button">Ingresar</button>
            </form>
        </div>
    );
};

export default Login;
