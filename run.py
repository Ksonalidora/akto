try:
    # Your code that may potentially raise runtime errors
    result = 10 / 0  # This will raise a 'ZeroDivisionError'
except ZeroDivisionError as error:
    # Handle the specific error
    print(f"ZeroDivisionError: {error}")
except Exception as error:
    # Handle all other exceptions
    print(f"An error occurred: {error}")
else:
    # Code to run if there are no exceptions
    print("No errors occurred")
finally:
    # Code to run regardless of whether an error occurred
    print("Execution completed")

# The program continues after handling the error
print("Program continues after error handling")
