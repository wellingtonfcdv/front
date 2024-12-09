const recipeList = document.querySelector('.recipe-list')
const form = document.querySelector('.search-form')

form.addEventListener('submit', function (event) {
    event.preventDefault()
    const inputValue = event.target[0].value

    searchRecipes(inputValue)
})

async function searchRecipes(ingredient) {
    const response = await fetch(`https://www.themealdb.com/api/json/v1/1/filter.php?i=${ingredient}`)
    const data = await response.json()
    console.log(data)

    showRecipes(data.meals)
}

function showRecipes(recipes) {
    recipeList.innerHTML = recipes.map(
        (element) => `
        <div class="recipe-card" onclick="getRecipesDetails(${element.idMeal})">
            <img src="${element.strMealThumb}" alt="receita-foto">
            <h3>${element.strMeal}</h3>
        </div>
        `
    ).join('')
}

async function getRecipesDetails(id) {
    const response = await fetch(
        `https://www.themealdb.com/api/json/v1/1/lookup.php?i=${id}`
    )
    const data = await response.json()
    const recipe = data.meals[0]
    console.log(recipe)

    let ingredients = ''
    for (let i = 1; i <= 20; i++) {
        if (recipe[`strIngredient${i}`]) {
            ingredients += `<li>${recipe[`strIngredient${i}`]} - ${recipe[`strMeasure${i}`]}</li>`
            
        } else {
            break;
        }
    }
}