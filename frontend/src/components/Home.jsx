import React, {useState} from 'react';

const Home = () => {
    const [joke, setJoke] = useState('');
    const [isLoading, setIsLoading]=useState(false);
    const [error,setError]=useState('');

    const getJokeData=async()=>{
        setError('');
        try{
            setIsLoading(true);
            const BASE_URL = import.meta.env.VITE_API_BASE_URL;
            const response=await fetch(BASE_URL + "/joke");
            const data = await response.json();
            if(response.ok) {
                setJoke(data.text);
            }
            else{
                setError(data.error);
                setJoke('');
            }

        }
        catch(error){
            console.log(error);
            setError(error.message);

        }
        setIsLoading(false);
    }

    return (<>
        <div>
            Welcome to SnapJoke
        </div>
        <button disabled={isLoading} onClick={getJokeData}>{isLoading?'Loading':'Press To Get A Joke'}</button>
        {error?<div>{error}</div>:joke?<div>{joke}</div>: <p>No Joke Yet</p>}
    </>)
}

export default Home;