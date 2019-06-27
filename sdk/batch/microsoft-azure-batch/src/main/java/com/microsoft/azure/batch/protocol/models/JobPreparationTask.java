/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Job Preparation Task to run before any Tasks of the Job on any given
 * Compute Node.
 * You can use Job Preparation to prepare a Node to run Tasks for the Job.
 * Activities commonly performed in Job Preparation include: Downloading common
 * resource files used by all the Tasks in the Job. The Job Preparation Task
 * can download these common resource files to the shared location on the Node.
 * (AZ_BATCH_NODE_ROOT_DIR\shared), or starting a local service on the Node so
 * that all Tasks of that Job can communicate with it. If the Job Preparation
 * Task fails (that is, exhausts its retry count before exiting with exit code
 * 0), Batch will not run Tasks of this Job on the Node. The Compute Node
 * remains ineligible to run Tasks of this Job until it is reimaged. The
 * Compute Node remains active and can be used for other Jobs. The Job
 * Preparation Task can run multiple times on the same Node. Therefore, you
 * should write the Job Preparation Task to handle re-execution. If the Node is
 * rebooted, the Job Preparation Task is run again on the Compute Node before
 * scheduling any other Task of the Job, if rerunOnNodeRebootAfterSuccess is
 * true or if the Job Preparation Task did not previously complete. If the Node
 * is reimaged, the Job Preparation Task is run again before scheduling any
 * Task of the Job. Batch will retry Tasks when a recovery operation is
 * triggered on a Node. Examples of recovery operations include (but are not
 * limited to) when an unhealthy Node is rebooted or a Compute Node disappeared
 * due to host failure. Retries due to recovery operations are independent of
 * and are not counted against the maxTaskRetryCount. Even if the
 * maxTaskRetryCount is 0, an internal retry due to a recovery operation may
 * occur. Because of this, all Tasks should be idempotent. This means Tasks
 * need to tolerate being interrupted and restarted without causing any
 * corruption or duplicate data. The best practice for long running Tasks is to
 * use some form of checkpointing.
 */
public class JobPreparationTask {
    /**
     * A string that uniquely identifies the Job Preparation Task within the
     * Job.
     * The ID can contain any combination of alphanumeric characters including
     * hyphens and underscores and cannot contain more than 64 characters. If
     * you do not specify this property, the Batch service assigns a default
     * value of 'jobpreparation'. No other Task in the Job can have the same ID
     * as the Job Preparation Task. If you try to submit a Task with the same
     * id, the Batch service rejects the request with error code
     * TaskIdSameAsJobPreparationTask; if you are calling the REST API
     * directly, the HTTP status code is 409 (Conflict).
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * The command line of the Job Preparation Task.
     * The command line does not run under a shell, and therefore cannot take
     * advantage of shell features such as environment variable expansion. If
     * you want to take advantage of such features, you should invoke the shell
     * in the command line, for example using "cmd /c MyCommand" in Windows or
     * "/bin/sh -c MyCommand" in Linux. If the command line refers to file
     * paths, it should use a relative path (relative to the Task working
     * directory), or use the Batch provided environment variable
     * (https://docs.microsoft.com/en-us/azure/batch/batch-compute-node-environment-variables).
     */
    @JsonProperty(value = "commandLine", required = true)
    private String commandLine;

    /**
     * The settings for the container under which the Job Preparation Task
     * runs.
     * When this is specified, all directories recursively below the
     * AZ_BATCH_NODE_ROOT_DIR (the root of Azure Batch directories on the node)
     * are mapped into the container, all Task environment variables are mapped
     * into the container, and the Task command line is executed in the
     * container. Files produced in the container outside of
     * AZ_BATCH_NODE_ROOT_DIR might not be reflected to the host disk, meaning
     * that Batch file APIs will not be able to access those files.
     */
    @JsonProperty(value = "containerSettings")
    private TaskContainerSettings containerSettings;

    /**
     * A list of files that the Batch service will download to the Compute Node
     * before running the command line.
     * Files listed under this element are located in the Task's working
     * directory.  There is a maximum size for the list of resource files.
     * When the max size is exceeded, the request will fail and the response
     * error code will be RequestEntityTooLarge. If this occurs, the collection
     * of ResourceFiles must be reduced in size. This can be achieved using
     * .zip files, Application Packages, or Docker Containers.
     */
    @JsonProperty(value = "resourceFiles")
    private List<ResourceFile> resourceFiles;

    /**
     * A list of environment variable settings for the Job Preparation Task.
     */
    @JsonProperty(value = "environmentSettings")
    private List<EnvironmentSetting> environmentSettings;

    /**
     * Constraints that apply to the Job Preparation Task.
     */
    @JsonProperty(value = "constraints")
    private TaskConstraints constraints;

    /**
     * Whether the Batch service should wait for the Job Preparation Task to
     * complete successfully before scheduling any other Tasks of the Job on
     * the Compute Node. A Job Preparation Task has completed successfully if
     * it exits with exit code 0.
     * If true and the Job Preparation Task fails on a Node, the Batch service
     * retries the Job Preparation Task up to its maximum retry count (as
     * specified in the constraints element). If the Task has still not
     * completed successfully after all retries, then the Batch service will
     * not schedule Tasks of the Job to the Node. The Node remains active and
     * eligible to run Tasks of other Jobs. If false, the Batch service will
     * not wait for the Job Preparation Task to complete. In this case, other
     * Tasks of the Job can start executing on the Compute Node while the Job
     * Preparation Task is still running; and even if the Job Preparation Task
     * fails, new Tasks will continue to be scheduled on the Compute Node. The
     * default value is true.
     */
    @JsonProperty(value = "waitForSuccess")
    private Boolean waitForSuccess;

    /**
     * The user identity under which the Job Preparation Task runs.
     * If omitted, the Task runs as a non-administrative user unique to the
     * Task on Windows Compute Nodes, or a non-administrative user unique to
     * the Pool on Linux Compute Nodes.
     */
    @JsonProperty(value = "userIdentity")
    private UserIdentity userIdentity;

    /**
     * Whether the Batch service should rerun the Job Preparation Task after a
     * Compute Node reboots.
     * The Job Preparation Task is always rerun if a Compute Node is reimaged,
     * or if the Job Preparation Task did not complete (e.g. because the reboot
     * occurred while the Task was running). Therefore, you should always write
     * a Job Preparation Task to be idempotent and to behave correctly if run
     * multiple times. The default value is true.
     */
    @JsonProperty(value = "rerunOnNodeRebootAfterSuccess")
    private Boolean rerunOnNodeRebootAfterSuccess;

    /**
     * Get the ID can contain any combination of alphanumeric characters including hyphens and underscores and cannot contain more than 64 characters. If you do not specify this property, the Batch service assigns a default value of 'jobpreparation'. No other Task in the Job can have the same ID as the Job Preparation Task. If you try to submit a Task with the same id, the Batch service rejects the request with error code TaskIdSameAsJobPreparationTask; if you are calling the REST API directly, the HTTP status code is 409 (Conflict).
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the ID can contain any combination of alphanumeric characters including hyphens and underscores and cannot contain more than 64 characters. If you do not specify this property, the Batch service assigns a default value of 'jobpreparation'. No other Task in the Job can have the same ID as the Job Preparation Task. If you try to submit a Task with the same id, the Batch service rejects the request with error code TaskIdSameAsJobPreparationTask; if you are calling the REST API directly, the HTTP status code is 409 (Conflict).
     *
     * @param id the id value to set
     * @return the JobPreparationTask object itself.
     */
    public JobPreparationTask withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the command line does not run under a shell, and therefore cannot take advantage of shell features such as environment variable expansion. If you want to take advantage of such features, you should invoke the shell in the command line, for example using "cmd /c MyCommand" in Windows or "/bin/sh -c MyCommand" in Linux. If the command line refers to file paths, it should use a relative path (relative to the Task working directory), or use the Batch provided environment variable (https://docs.microsoft.com/en-us/azure/batch/batch-compute-node-environment-variables).
     *
     * @return the commandLine value
     */
    public String commandLine() {
        return this.commandLine;
    }

    /**
     * Set the command line does not run under a shell, and therefore cannot take advantage of shell features such as environment variable expansion. If you want to take advantage of such features, you should invoke the shell in the command line, for example using "cmd /c MyCommand" in Windows or "/bin/sh -c MyCommand" in Linux. If the command line refers to file paths, it should use a relative path (relative to the Task working directory), or use the Batch provided environment variable (https://docs.microsoft.com/en-us/azure/batch/batch-compute-node-environment-variables).
     *
     * @param commandLine the commandLine value to set
     * @return the JobPreparationTask object itself.
     */
    public JobPreparationTask withCommandLine(String commandLine) {
        this.commandLine = commandLine;
        return this;
    }

    /**
     * Get when this is specified, all directories recursively below the AZ_BATCH_NODE_ROOT_DIR (the root of Azure Batch directories on the node) are mapped into the container, all Task environment variables are mapped into the container, and the Task command line is executed in the container. Files produced in the container outside of AZ_BATCH_NODE_ROOT_DIR might not be reflected to the host disk, meaning that Batch file APIs will not be able to access those files.
     *
     * @return the containerSettings value
     */
    public TaskContainerSettings containerSettings() {
        return this.containerSettings;
    }

    /**
     * Set when this is specified, all directories recursively below the AZ_BATCH_NODE_ROOT_DIR (the root of Azure Batch directories on the node) are mapped into the container, all Task environment variables are mapped into the container, and the Task command line is executed in the container. Files produced in the container outside of AZ_BATCH_NODE_ROOT_DIR might not be reflected to the host disk, meaning that Batch file APIs will not be able to access those files.
     *
     * @param containerSettings the containerSettings value to set
     * @return the JobPreparationTask object itself.
     */
    public JobPreparationTask withContainerSettings(TaskContainerSettings containerSettings) {
        this.containerSettings = containerSettings;
        return this;
    }

    /**
     * Get files listed under this element are located in the Task's working directory.  There is a maximum size for the list of resource files.  When the max size is exceeded, the request will fail and the response error code will be RequestEntityTooLarge. If this occurs, the collection of ResourceFiles must be reduced in size. This can be achieved using .zip files, Application Packages, or Docker Containers.
     *
     * @return the resourceFiles value
     */
    public List<ResourceFile> resourceFiles() {
        return this.resourceFiles;
    }

    /**
     * Set files listed under this element are located in the Task's working directory.  There is a maximum size for the list of resource files.  When the max size is exceeded, the request will fail and the response error code will be RequestEntityTooLarge. If this occurs, the collection of ResourceFiles must be reduced in size. This can be achieved using .zip files, Application Packages, or Docker Containers.
     *
     * @param resourceFiles the resourceFiles value to set
     * @return the JobPreparationTask object itself.
     */
    public JobPreparationTask withResourceFiles(List<ResourceFile> resourceFiles) {
        this.resourceFiles = resourceFiles;
        return this;
    }

    /**
     * Get the environmentSettings value.
     *
     * @return the environmentSettings value
     */
    public List<EnvironmentSetting> environmentSettings() {
        return this.environmentSettings;
    }

    /**
     * Set the environmentSettings value.
     *
     * @param environmentSettings the environmentSettings value to set
     * @return the JobPreparationTask object itself.
     */
    public JobPreparationTask withEnvironmentSettings(List<EnvironmentSetting> environmentSettings) {
        this.environmentSettings = environmentSettings;
        return this;
    }

    /**
     * Get the constraints value.
     *
     * @return the constraints value
     */
    public TaskConstraints constraints() {
        return this.constraints;
    }

    /**
     * Set the constraints value.
     *
     * @param constraints the constraints value to set
     * @return the JobPreparationTask object itself.
     */
    public JobPreparationTask withConstraints(TaskConstraints constraints) {
        this.constraints = constraints;
        return this;
    }

    /**
     * Get if true and the Job Preparation Task fails on a Node, the Batch service retries the Job Preparation Task up to its maximum retry count (as specified in the constraints element). If the Task has still not completed successfully after all retries, then the Batch service will not schedule Tasks of the Job to the Node. The Node remains active and eligible to run Tasks of other Jobs. If false, the Batch service will not wait for the Job Preparation Task to complete. In this case, other Tasks of the Job can start executing on the Compute Node while the Job Preparation Task is still running; and even if the Job Preparation Task fails, new Tasks will continue to be scheduled on the Compute Node. The default value is true.
     *
     * @return the waitForSuccess value
     */
    public Boolean waitForSuccess() {
        return this.waitForSuccess;
    }

    /**
     * Set if true and the Job Preparation Task fails on a Node, the Batch service retries the Job Preparation Task up to its maximum retry count (as specified in the constraints element). If the Task has still not completed successfully after all retries, then the Batch service will not schedule Tasks of the Job to the Node. The Node remains active and eligible to run Tasks of other Jobs. If false, the Batch service will not wait for the Job Preparation Task to complete. In this case, other Tasks of the Job can start executing on the Compute Node while the Job Preparation Task is still running; and even if the Job Preparation Task fails, new Tasks will continue to be scheduled on the Compute Node. The default value is true.
     *
     * @param waitForSuccess the waitForSuccess value to set
     * @return the JobPreparationTask object itself.
     */
    public JobPreparationTask withWaitForSuccess(Boolean waitForSuccess) {
        this.waitForSuccess = waitForSuccess;
        return this;
    }

    /**
     * Get if omitted, the Task runs as a non-administrative user unique to the Task on Windows Compute Nodes, or a non-administrative user unique to the Pool on Linux Compute Nodes.
     *
     * @return the userIdentity value
     */
    public UserIdentity userIdentity() {
        return this.userIdentity;
    }

    /**
     * Set if omitted, the Task runs as a non-administrative user unique to the Task on Windows Compute Nodes, or a non-administrative user unique to the Pool on Linux Compute Nodes.
     *
     * @param userIdentity the userIdentity value to set
     * @return the JobPreparationTask object itself.
     */
    public JobPreparationTask withUserIdentity(UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
        return this;
    }

    /**
     * Get the Job Preparation Task is always rerun if a Compute Node is reimaged, or if the Job Preparation Task did not complete (e.g. because the reboot occurred while the Task was running). Therefore, you should always write a Job Preparation Task to be idempotent and to behave correctly if run multiple times. The default value is true.
     *
     * @return the rerunOnNodeRebootAfterSuccess value
     */
    public Boolean rerunOnNodeRebootAfterSuccess() {
        return this.rerunOnNodeRebootAfterSuccess;
    }

    /**
     * Set the Job Preparation Task is always rerun if a Compute Node is reimaged, or if the Job Preparation Task did not complete (e.g. because the reboot occurred while the Task was running). Therefore, you should always write a Job Preparation Task to be idempotent and to behave correctly if run multiple times. The default value is true.
     *
     * @param rerunOnNodeRebootAfterSuccess the rerunOnNodeRebootAfterSuccess value to set
     * @return the JobPreparationTask object itself.
     */
    public JobPreparationTask withRerunOnNodeRebootAfterSuccess(Boolean rerunOnNodeRebootAfterSuccess) {
        this.rerunOnNodeRebootAfterSuccess = rerunOnNodeRebootAfterSuccess;
        return this;
    }

}
